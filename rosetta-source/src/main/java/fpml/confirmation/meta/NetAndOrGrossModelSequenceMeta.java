package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NetAndOrGrossModelSequence;
import fpml.confirmation.validation.NetAndOrGrossModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.NetAndOrGrossModelSequenceValidator;
import fpml.confirmation.validation.exists.NetAndOrGrossModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NetAndOrGrossModelSequence.class)
public class NetAndOrGrossModelSequenceMeta implements RosettaMetaData<NetAndOrGrossModelSequence> {

	@Override
	public List<Validator<? super NetAndOrGrossModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NetAndOrGrossModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NetAndOrGrossModelSequence> validator() {
		return new NetAndOrGrossModelSequenceValidator();
	}

	@Override
	public Validator<? super NetAndOrGrossModelSequence> typeFormatValidator() {
		return new NetAndOrGrossModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NetAndOrGrossModelSequence, Set<String>> onlyExistsValidator() {
		return new NetAndOrGrossModelSequenceOnlyExistsValidator();
	}
}
