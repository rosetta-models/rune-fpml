package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExtendibleProvision;
import fpml.confirmation.validation.ExtendibleProvisionTypeFormatValidator;
import fpml.confirmation.validation.ExtendibleProvisionValidator;
import fpml.confirmation.validation.exists.ExtendibleProvisionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExtendibleProvision.class)
public class ExtendibleProvisionMeta implements RosettaMetaData<ExtendibleProvision> {

	@Override
	public List<Validator<? super ExtendibleProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExtendibleProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExtendibleProvision> validator() {
		return new ExtendibleProvisionValidator();
	}

	@Override
	public Validator<? super ExtendibleProvision> typeFormatValidator() {
		return new ExtendibleProvisionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtendibleProvision, Set<String>> onlyExistsValidator() {
		return new ExtendibleProvisionOnlyExistsValidator();
	}
}
