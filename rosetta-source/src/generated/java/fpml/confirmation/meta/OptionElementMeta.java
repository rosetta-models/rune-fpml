package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionElement;
import fpml.confirmation.validation.OptionElementTypeFormatValidator;
import fpml.confirmation.validation.OptionElementValidator;
import fpml.confirmation.validation.exists.OptionElementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionElement.class)
public class OptionElementMeta implements RosettaMetaData<OptionElement> {

	@Override
	public List<Validator<? super OptionElement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionElement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionElement> validator() {
		return new OptionElementValidator();
	}

	@Override
	public Validator<? super OptionElement> typeFormatValidator() {
		return new OptionElementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionElement, Set<String>> onlyExistsValidator() {
		return new OptionElementOnlyExistsValidator();
	}
}
