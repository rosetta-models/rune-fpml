package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationAmountsOldModelSequence2;
import fpml.confirmation.validation.NovationAmountsOldModelSequence2TypeFormatValidator;
import fpml.confirmation.validation.NovationAmountsOldModelSequence2Validator;
import fpml.confirmation.validation.exists.NovationAmountsOldModelSequence2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NovationAmountsOldModelSequence2.class)
public class NovationAmountsOldModelSequence2Meta implements RosettaMetaData<NovationAmountsOldModelSequence2> {

	@Override
	public List<Validator<? super NovationAmountsOldModelSequence2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NovationAmountsOldModelSequence2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationAmountsOldModelSequence2> validator() {
		return new NovationAmountsOldModelSequence2Validator();
	}

	@Override
	public Validator<? super NovationAmountsOldModelSequence2> typeFormatValidator() {
		return new NovationAmountsOldModelSequence2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationAmountsOldModelSequence2, Set<String>> onlyExistsValidator() {
		return new NovationAmountsOldModelSequence2OnlyExistsValidator();
	}
}
