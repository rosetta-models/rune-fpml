package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralType;
import fpml.confirmation.validation.CollateralTypeTypeFormatValidator;
import fpml.confirmation.validation.CollateralTypeValidator;
import fpml.confirmation.validation.exists.CollateralTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CollateralType.class)
public class CollateralTypeMeta implements RosettaMetaData<CollateralType> {

	@Override
	public List<Validator<? super CollateralType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralType> validator() {
		return new CollateralTypeValidator();
	}

	@Override
	public Validator<? super CollateralType> typeFormatValidator() {
		return new CollateralTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralType, Set<String>> onlyExistsValidator() {
		return new CollateralTypeOnlyExistsValidator();
	}
}
