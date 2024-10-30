package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceElement;
import fpml.confirmation.validation.ReferenceElementTypeFormatValidator;
import fpml.confirmation.validation.ReferenceElementValidator;
import fpml.confirmation.validation.exists.ReferenceElementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReferenceElement.class)
public class ReferenceElementMeta implements RosettaMetaData<ReferenceElement> {

	@Override
	public List<Validator<? super ReferenceElement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceElement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceElement> validator() {
		return new ReferenceElementValidator();
	}

	@Override
	public Validator<? super ReferenceElement> typeFormatValidator() {
		return new ReferenceElementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceElement, Set<String>> onlyExistsValidator() {
		return new ReferenceElementOnlyExistsValidator();
	}
}
