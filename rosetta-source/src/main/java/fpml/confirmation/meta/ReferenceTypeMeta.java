package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.validation.ReferenceTypeTypeFormatValidator;
import fpml.confirmation.validation.ReferenceTypeValidator;
import fpml.confirmation.validation.exists.ReferenceTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReferenceType.class)
public class ReferenceTypeMeta implements RosettaMetaData<ReferenceType> {

	@Override
	public List<Validator<? super ReferenceType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceType> validator() {
		return new ReferenceTypeValidator();
	}

	@Override
	public Validator<? super ReferenceType> typeFormatValidator() {
		return new ReferenceTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceType, Set<String>> onlyExistsValidator() {
		return new ReferenceTypeOnlyExistsValidator();
	}
}
