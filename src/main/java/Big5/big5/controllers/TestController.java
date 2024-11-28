package Big5.big5.controllers;


import Big5.big5.dtos.EvaluationResult;
import Big5.big5.dtos.LinePoints;
import Big5.big5.service.PersonalityTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final PersonalityTestService personalityTestService;

    @PostMapping("/tests")
    public String test(@ModelAttribute("linePoints") LinePoints linePoints, Model model) {
        var evaluation = personalityTestService.evaluate(linePoints);
        //화면단에서 받은 데이터를 서비스로 넘겨 만든 객체를 변환해서 반환
        var result = EvaluationResult.builder()
                .extraversionValue(evaluation.getExtraversionValue())
                .neuroticismValue(evaluation.getNeuroticismValue())
                .conscientiousnessValue(evaluation.getConscientiousnessValue())
                .agreeablenessValue(evaluation.getAgreeablenessValue())
                .opennessValue(evaluation.getOpennessValue())
                .commentary(evaluation.getCommentary().getComments())
                .build();

        model.addAttribute("evaluation", result);
        return "result";
    }


}
