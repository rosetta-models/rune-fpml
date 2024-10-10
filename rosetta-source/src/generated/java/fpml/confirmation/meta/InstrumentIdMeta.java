package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.validation.InstrumentIdTypeFormatValidator;
import fpml.confirmation.validation.InstrumentIdValidator;
import fpml.confirmation.validation.exists.InstrumentIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InstrumentId.class)
public class InstrumentIdMeta implements RosettaMetaData<InstrumentId> {

	@Override
	public List<Validator<? super InstrumentId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InstrumentId> validator() {
		return new InstrumentIdValidator();
	}

	@Override
	public Validator<? super InstrumentId> typeFormatValidator() {
		return new InstrumentIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentId, Set<String>> onlyExistsValidator() {
		return new InstrumentIdOnlyExistsValidator();
	}
}
