package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EarlyTerminationProvision;
import fpml.confirmation.validation.EarlyTerminationProvisionTypeFormatValidator;
import fpml.confirmation.validation.EarlyTerminationProvisionValidator;
import fpml.confirmation.validation.exists.EarlyTerminationProvisionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EarlyTerminationProvision.class)
public class EarlyTerminationProvisionMeta implements RosettaMetaData<EarlyTerminationProvision> {

	@Override
	public List<Validator<? super EarlyTerminationProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EarlyTerminationProvision>create(fpml.confirmation.validation.datarule.EarlyTerminationProvisionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EarlyTerminationProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EarlyTerminationProvision> validator() {
		return new EarlyTerminationProvisionValidator();
	}

	@Override
	public Validator<? super EarlyTerminationProvision> typeFormatValidator() {
		return new EarlyTerminationProvisionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EarlyTerminationProvision, Set<String>> onlyExistsValidator() {
		return new EarlyTerminationProvisionOnlyExistsValidator();
	}
}
