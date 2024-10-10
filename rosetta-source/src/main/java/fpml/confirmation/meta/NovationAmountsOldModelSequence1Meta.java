package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationAmountsOldModelSequence1;
import fpml.confirmation.validation.NovationAmountsOldModelSequence1TypeFormatValidator;
import fpml.confirmation.validation.NovationAmountsOldModelSequence1Validator;
import fpml.confirmation.validation.exists.NovationAmountsOldModelSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NovationAmountsOldModelSequence1.class)
public class NovationAmountsOldModelSequence1Meta implements RosettaMetaData<NovationAmountsOldModelSequence1> {

	@Override
	public List<Validator<? super NovationAmountsOldModelSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NovationAmountsOldModelSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationAmountsOldModelSequence1> validator() {
		return new NovationAmountsOldModelSequence1Validator();
	}

	@Override
	public Validator<? super NovationAmountsOldModelSequence1> typeFormatValidator() {
		return new NovationAmountsOldModelSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationAmountsOldModelSequence1, Set<String>> onlyExistsValidator() {
		return new NovationAmountsOldModelSequence1OnlyExistsValidator();
	}
}
