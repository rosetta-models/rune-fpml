package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PackageHeader;
import fpml.confirmation.validation.PackageHeaderTypeFormatValidator;
import fpml.confirmation.validation.PackageHeaderValidator;
import fpml.confirmation.validation.exists.PackageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PackageHeader.class)
public class PackageHeaderMeta implements RosettaMetaData<PackageHeader> {

	@Override
	public List<Validator<? super PackageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PackageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PackageHeader> validator() {
		return new PackageHeaderValidator();
	}

	@Override
	public Validator<? super PackageHeader> typeFormatValidator() {
		return new PackageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PackageHeader, Set<String>> onlyExistsValidator() {
		return new PackageHeaderOnlyExistsValidator();
	}
}
