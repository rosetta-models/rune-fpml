package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeAmendmentContent;
import fpml.confirmation.validation.TradeAmendmentContentTypeFormatValidator;
import fpml.confirmation.validation.TradeAmendmentContentValidator;
import fpml.confirmation.validation.exists.TradeAmendmentContentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeAmendmentContent.class)
public class TradeAmendmentContentMeta implements RosettaMetaData<TradeAmendmentContent> {

	@Override
	public List<Validator<? super TradeAmendmentContent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeAmendmentContent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeAmendmentContent> validator() {
		return new TradeAmendmentContentValidator();
	}

	@Override
	public Validator<? super TradeAmendmentContent> typeFormatValidator() {
		return new TradeAmendmentContentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeAmendmentContent, Set<String>> onlyExistsValidator() {
		return new TradeAmendmentContentOnlyExistsValidator();
	}
}
