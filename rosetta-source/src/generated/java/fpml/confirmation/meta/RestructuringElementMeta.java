package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RestructuringElement;
import fpml.confirmation.validation.RestructuringElementTypeFormatValidator;
import fpml.confirmation.validation.RestructuringElementValidator;
import fpml.confirmation.validation.exists.RestructuringElementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RestructuringElement.class)
public class RestructuringElementMeta implements RosettaMetaData<RestructuringElement> {

	@Override
	public List<Validator<? super RestructuringElement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RestructuringElement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RestructuringElement> validator() {
		return new RestructuringElementValidator();
	}

	@Override
	public Validator<? super RestructuringElement> typeFormatValidator() {
		return new RestructuringElementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RestructuringElement, Set<String>> onlyExistsValidator() {
		return new RestructuringElementOnlyExistsValidator();
	}
}
