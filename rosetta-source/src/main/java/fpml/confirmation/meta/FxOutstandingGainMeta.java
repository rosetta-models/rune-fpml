package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxOutstandingGain;
import fpml.confirmation.validation.FxOutstandingGainTypeFormatValidator;
import fpml.confirmation.validation.FxOutstandingGainValidator;
import fpml.confirmation.validation.exists.FxOutstandingGainOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxOutstandingGain.class)
public class FxOutstandingGainMeta implements RosettaMetaData<FxOutstandingGain> {

	@Override
	public List<Validator<? super FxOutstandingGain>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxOutstandingGain, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxOutstandingGain> validator() {
		return new FxOutstandingGainValidator();
	}

	@Override
	public Validator<? super FxOutstandingGain> typeFormatValidator() {
		return new FxOutstandingGainTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOutstandingGain, Set<String>> onlyExistsValidator() {
		return new FxOutstandingGainOnlyExistsValidator();
	}
}
