package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CanonicalizationMethodType;
import fpml.confirmation.validation.CanonicalizationMethodTypeTypeFormatValidator;
import fpml.confirmation.validation.CanonicalizationMethodTypeValidator;
import fpml.confirmation.validation.exists.CanonicalizationMethodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CanonicalizationMethodType.class)
public class CanonicalizationMethodTypeMeta implements RosettaMetaData<CanonicalizationMethodType> {

	@Override
	public List<Validator<? super CanonicalizationMethodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CanonicalizationMethodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CanonicalizationMethodType> validator() {
		return new CanonicalizationMethodTypeValidator();
	}

	@Override
	public Validator<? super CanonicalizationMethodType> typeFormatValidator() {
		return new CanonicalizationMethodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CanonicalizationMethodType, Set<String>> onlyExistsValidator() {
		return new CanonicalizationMethodTypeOnlyExistsValidator();
	}
}
