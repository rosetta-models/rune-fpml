package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PGPDataType;
import fpml.confirmation.validation.PGPDataTypeTypeFormatValidator;
import fpml.confirmation.validation.PGPDataTypeValidator;
import fpml.confirmation.validation.exists.PGPDataTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PGPDataType.class)
public class PGPDataTypeMeta implements RosettaMetaData<PGPDataType> {

	@Override
	public List<Validator<? super PGPDataType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PGPDataType>create(fpml.confirmation.validation.datarule.PGPDataTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PGPDataType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PGPDataType> validator() {
		return new PGPDataTypeValidator();
	}

	@Override
	public Validator<? super PGPDataType> typeFormatValidator() {
		return new PGPDataTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PGPDataType, Set<String>> onlyExistsValidator() {
		return new PGPDataTypeOnlyExistsValidator();
	}
}
