package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeChangeContent;
import fpml.confirmation.validation.TradeChangeContentTypeFormatValidator;
import fpml.confirmation.validation.TradeChangeContentValidator;
import fpml.confirmation.validation.exists.TradeChangeContentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeChangeContent.class)
public class TradeChangeContentMeta implements RosettaMetaData<TradeChangeContent> {

	@Override
	public List<Validator<? super TradeChangeContent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeChangeContent>create(fpml.confirmation.validation.datarule.TradeChangeContentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeChangeContent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeChangeContent> validator() {
		return new TradeChangeContentValidator();
	}

	@Override
	public Validator<? super TradeChangeContent> typeFormatValidator() {
		return new TradeChangeContentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeContent, Set<String>> onlyExistsValidator() {
		return new TradeChangeContentOnlyExistsValidator();
	}
}
