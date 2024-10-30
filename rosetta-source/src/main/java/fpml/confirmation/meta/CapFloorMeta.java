package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CapFloor;
import fpml.confirmation.validation.CapFloorTypeFormatValidator;
import fpml.confirmation.validation.CapFloorValidator;
import fpml.confirmation.validation.exists.CapFloorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CapFloor.class)
public class CapFloorMeta implements RosettaMetaData<CapFloor> {

	@Override
	public List<Validator<? super CapFloor>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CapFloor, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CapFloor> validator() {
		return new CapFloorValidator();
	}

	@Override
	public Validator<? super CapFloor> typeFormatValidator() {
		return new CapFloorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CapFloor, Set<String>> onlyExistsValidator() {
		return new CapFloorOnlyExistsValidator();
	}
}
