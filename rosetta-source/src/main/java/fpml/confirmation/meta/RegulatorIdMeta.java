package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RegulatorId;
import fpml.confirmation.validation.RegulatorIdTypeFormatValidator;
import fpml.confirmation.validation.RegulatorIdValidator;
import fpml.confirmation.validation.exists.RegulatorIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RegulatorId.class)
public class RegulatorIdMeta implements RosettaMetaData<RegulatorId> {

	@Override
	public List<Validator<? super RegulatorId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatorId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RegulatorId> validator() {
		return new RegulatorIdValidator();
	}

	@Override
	public Validator<? super RegulatorId> typeFormatValidator() {
		return new RegulatorIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatorId, Set<String>> onlyExistsValidator() {
		return new RegulatorIdOnlyExistsValidator();
	}
}
