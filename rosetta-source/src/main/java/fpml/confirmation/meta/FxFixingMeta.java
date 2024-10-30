package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixing;
import fpml.confirmation.validation.FxFixingTypeFormatValidator;
import fpml.confirmation.validation.FxFixingValidator;
import fpml.confirmation.validation.exists.FxFixingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxFixing.class)
public class FxFixingMeta implements RosettaMetaData<FxFixing> {

	@Override
	public List<Validator<? super FxFixing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFixing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixing> validator() {
		return new FxFixingValidator();
	}

	@Override
	public Validator<? super FxFixing> typeFormatValidator() {
		return new FxFixingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixing, Set<String>> onlyExistsValidator() {
		return new FxFixingOnlyExistsValidator();
	}
}
