package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNovationContent;
import fpml.confirmation.validation.TradeNovationContentTypeFormatValidator;
import fpml.confirmation.validation.TradeNovationContentValidator;
import fpml.confirmation.validation.exists.TradeNovationContentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeNovationContent.class)
public class TradeNovationContentMeta implements RosettaMetaData<TradeNovationContent> {

	@Override
	public List<Validator<? super TradeNovationContent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeNovationContent>create(fpml.confirmation.validation.datarule.TradeNovationContentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeNovationContent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeNovationContent> validator() {
		return new TradeNovationContentValidator();
	}

	@Override
	public Validator<? super TradeNovationContent> typeFormatValidator() {
		return new TradeNovationContentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNovationContent, Set<String>> onlyExistsValidator() {
		return new TradeNovationContentOnlyExistsValidator();
	}
}
