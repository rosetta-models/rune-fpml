package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceLevelUnit;
import fpml.confirmation.validation.ReferenceLevelUnitTypeFormatValidator;
import fpml.confirmation.validation.ReferenceLevelUnitValidator;
import fpml.confirmation.validation.exists.ReferenceLevelUnitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReferenceLevelUnit.class)
public class ReferenceLevelUnitMeta implements RosettaMetaData<ReferenceLevelUnit> {

	@Override
	public List<Validator<? super ReferenceLevelUnit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceLevelUnit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceLevelUnit> validator() {
		return new ReferenceLevelUnitValidator();
	}

	@Override
	public Validator<? super ReferenceLevelUnit> typeFormatValidator() {
		return new ReferenceLevelUnitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceLevelUnit, Set<String>> onlyExistsValidator() {
		return new ReferenceLevelUnitOnlyExistsValidator();
	}
}
