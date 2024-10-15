package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PackageType;
import fpml.confirmation.validation.PackageTypeTypeFormatValidator;
import fpml.confirmation.validation.PackageTypeValidator;
import fpml.confirmation.validation.exists.PackageTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PackageType.class)
public class PackageTypeMeta implements RosettaMetaData<PackageType> {

	@Override
	public List<Validator<? super PackageType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PackageType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PackageType> validator() {
		return new PackageTypeValidator();
	}

	@Override
	public Validator<? super PackageType> typeFormatValidator() {
		return new PackageTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PackageType, Set<String>> onlyExistsValidator() {
		return new PackageTypeOnlyExistsValidator();
	}
}
