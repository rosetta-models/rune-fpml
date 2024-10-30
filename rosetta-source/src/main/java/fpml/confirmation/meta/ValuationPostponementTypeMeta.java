package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationPostponementType;
import fpml.confirmation.validation.ValuationPostponementTypeTypeFormatValidator;
import fpml.confirmation.validation.ValuationPostponementTypeValidator;
import fpml.confirmation.validation.exists.ValuationPostponementTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ValuationPostponementType.class)
public class ValuationPostponementTypeMeta implements RosettaMetaData<ValuationPostponementType> {

	@Override
	public List<Validator<? super ValuationPostponementType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationPostponementType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValuationPostponementType> validator() {
		return new ValuationPostponementTypeValidator();
	}

	@Override
	public Validator<? super ValuationPostponementType> typeFormatValidator() {
		return new ValuationPostponementTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationPostponementType, Set<String>> onlyExistsValidator() {
		return new ValuationPostponementTypeOnlyExistsValidator();
	}
}
