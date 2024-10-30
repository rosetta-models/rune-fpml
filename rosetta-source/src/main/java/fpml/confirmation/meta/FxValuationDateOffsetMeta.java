package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxValuationDateOffset;
import fpml.confirmation.validation.FxValuationDateOffsetTypeFormatValidator;
import fpml.confirmation.validation.FxValuationDateOffsetValidator;
import fpml.confirmation.validation.exists.FxValuationDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxValuationDateOffset.class)
public class FxValuationDateOffsetMeta implements RosettaMetaData<FxValuationDateOffset> {

	@Override
	public List<Validator<? super FxValuationDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxValuationDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxValuationDateOffset> validator() {
		return new FxValuationDateOffsetValidator();
	}

	@Override
	public Validator<? super FxValuationDateOffset> typeFormatValidator() {
		return new FxValuationDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxValuationDateOffset, Set<String>> onlyExistsValidator() {
		return new FxValuationDateOffsetOnlyExistsValidator();
	}
}
