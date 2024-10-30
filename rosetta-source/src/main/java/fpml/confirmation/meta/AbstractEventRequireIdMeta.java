package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractEventRequireId;
import fpml.confirmation.validation.AbstractEventRequireIdTypeFormatValidator;
import fpml.confirmation.validation.AbstractEventRequireIdValidator;
import fpml.confirmation.validation.exists.AbstractEventRequireIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractEventRequireId.class)
public class AbstractEventRequireIdMeta implements RosettaMetaData<AbstractEventRequireId> {

	@Override
	public List<Validator<? super AbstractEventRequireId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractEventRequireId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractEventRequireId> validator() {
		return new AbstractEventRequireIdValidator();
	}

	@Override
	public Validator<? super AbstractEventRequireId> typeFormatValidator() {
		return new AbstractEventRequireIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractEventRequireId, Set<String>> onlyExistsValidator() {
		return new AbstractEventRequireIdOnlyExistsValidator();
	}
}
