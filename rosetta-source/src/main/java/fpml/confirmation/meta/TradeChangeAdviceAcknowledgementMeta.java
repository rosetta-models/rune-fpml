package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeChangeAdviceAcknowledgement;
import fpml.confirmation.validation.TradeChangeAdviceAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.TradeChangeAdviceAcknowledgementValidator;
import fpml.confirmation.validation.exists.TradeChangeAdviceAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeChangeAdviceAcknowledgement.class)
public class TradeChangeAdviceAcknowledgementMeta implements RosettaMetaData<TradeChangeAdviceAcknowledgement> {

	@Override
	public List<Validator<? super TradeChangeAdviceAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeChangeAdviceAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeChangeAdviceAcknowledgement> validator() {
		return new TradeChangeAdviceAcknowledgementValidator();
	}

	@Override
	public Validator<? super TradeChangeAdviceAcknowledgement> typeFormatValidator() {
		return new TradeChangeAdviceAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeAdviceAcknowledgement, Set<String>> onlyExistsValidator() {
		return new TradeChangeAdviceAcknowledgementOnlyExistsValidator();
	}
}
