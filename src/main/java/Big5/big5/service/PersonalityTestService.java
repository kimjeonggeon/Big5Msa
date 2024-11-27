package Big5.big5.service;

import Big5.big5.adapters.SolarLLMsAdapter;
import Big5.big5.dtos.LinePoints;
import Big5.big5.entities.Commentary;
import Big5.big5.entities.Evaluation;
import Big5.big5.repositories.EvaluationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalityTestService {
    private final SolarLLMsAdapter solarLLMsAdapter;
    private final EvaluationRepository evaluationRepository;

    @Transactional
    public Evaluation evaluate(LinePoints linePoints) {
        // 평가 하기
        Evaluation evaluation = new Evaluation();
        evaluation.evaluate(linePoints);

        // LLMs에서 해설 가져오기
        String query = evaluation.makeQueryForCommentary();
        String comments = solarLLMsAdapter.chat(query);
        evaluation.setCommentary(new Commentary(comments));

        // 평가 값과 해설 DB에 저장
        evaluationRepository.save(evaluation);

        return evaluation;
    }

}
