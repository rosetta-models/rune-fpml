package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasPhysicalQuantitySequence;
import fpml.confirmation.validation.GasPhysicalQuantitySequenceTypeFormatValidator;
import fpml.confirmation.validation.GasPhysicalQuantitySequenceValidator;
import fpml.confirmation.validation.exists.GasPhysicalQuantitySequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GasPhysicalQuantitySequence.class)
public class GasPhysicalQuantitySequenceMeta implements RosettaMetaData<GasPhysicalQuantitySequence> {

	@Override
	public List<Validator<? super GasPhysicalQuantitySequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasPhysicalQuantitySequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasPhysicalQuantitySequence> validator() {
		return new GasPhysicalQuantitySequenceValidator();
	}

	@Override
	public Validator<? super GasPhysicalQuantitySequence> typeFormatValidator() {
		return new GasPhysicalQuantitySequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasPhysicalQuantitySequence, Set<String>> onlyExistsValidator() {
		return new GasPhysicalQuantitySequenceOnlyExistsValidator();
	}
}
