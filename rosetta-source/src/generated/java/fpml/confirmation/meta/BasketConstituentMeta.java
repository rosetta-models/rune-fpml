package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketConstituent;
import fpml.confirmation.validation.BasketConstituentTypeFormatValidator;
import fpml.confirmation.validation.BasketConstituentValidator;
import fpml.confirmation.validation.exists.BasketConstituentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BasketConstituent.class)
public class BasketConstituentMeta implements RosettaMetaData<BasketConstituent> {

	@Override
	public List<Validator<? super BasketConstituent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketConstituent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketConstituent> validator() {
		return new BasketConstituentValidator();
	}

	@Override
	public Validator<? super BasketConstituent> typeFormatValidator() {
		return new BasketConstituentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketConstituent, Set<String>> onlyExistsValidator() {
		return new BasketConstituentOnlyExistsValidator();
	}
}
