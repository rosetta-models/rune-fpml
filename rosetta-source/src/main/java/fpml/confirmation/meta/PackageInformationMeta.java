package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PackageInformation;
import fpml.confirmation.validation.PackageInformationTypeFormatValidator;
import fpml.confirmation.validation.PackageInformationValidator;
import fpml.confirmation.validation.exists.PackageInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PackageInformation.class)
public class PackageInformationMeta implements RosettaMetaData<PackageInformation> {

	@Override
	public List<Validator<? super PackageInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PackageInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PackageInformation> validator() {
		return new PackageInformationValidator();
	}

	@Override
	public Validator<? super PackageInformation> typeFormatValidator() {
		return new PackageInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PackageInformation, Set<String>> onlyExistsValidator() {
		return new PackageInformationOnlyExistsValidator();
	}
}
