package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationAmountsOldModelSequence0;
import fpml.confirmation.validation.NovationAmountsOldModelSequence0TypeFormatValidator;
import fpml.confirmation.validation.NovationAmountsOldModelSequence0Validator;
import fpml.confirmation.validation.exists.NovationAmountsOldModelSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NovationAmountsOldModelSequence0.class)
public class NovationAmountsOldModelSequence0Meta implements RosettaMetaData<NovationAmountsOldModelSequence0> {

	@Override
	public List<Validator<? super NovationAmountsOldModelSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NovationAmountsOldModelSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationAmountsOldModelSequence0> validator() {
		return new NovationAmountsOldModelSequence0Validator();
	}

	@Override
	public Validator<? super NovationAmountsOldModelSequence0> typeFormatValidator() {
		return new NovationAmountsOldModelSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationAmountsOldModelSequence0, Set<String>> onlyExistsValidator() {
		return new NovationAmountsOldModelSequence0OnlyExistsValidator();
	}
}
