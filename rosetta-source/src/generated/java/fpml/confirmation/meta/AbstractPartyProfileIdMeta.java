package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractPartyProfileId;
import fpml.confirmation.validation.AbstractPartyProfileIdTypeFormatValidator;
import fpml.confirmation.validation.AbstractPartyProfileIdValidator;
import fpml.confirmation.validation.exists.AbstractPartyProfileIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractPartyProfileId.class)
public class AbstractPartyProfileIdMeta implements RosettaMetaData<AbstractPartyProfileId> {

	@Override
	public List<Validator<? super AbstractPartyProfileId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractPartyProfileId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractPartyProfileId> validator() {
		return new AbstractPartyProfileIdValidator();
	}

	@Override
	public Validator<? super AbstractPartyProfileId> typeFormatValidator() {
		return new AbstractPartyProfileIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractPartyProfileId, Set<String>> onlyExistsValidator() {
		return new AbstractPartyProfileIdOnlyExistsValidator();
	}
}
