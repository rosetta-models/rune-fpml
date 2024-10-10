package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Transforms;
import fpml.confirmation.validation.TransformsTypeFormatValidator;
import fpml.confirmation.validation.TransformsValidator;
import fpml.confirmation.validation.exists.TransformsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Transforms.class)
public class TransformsMeta implements RosettaMetaData<Transforms> {

	@Override
	public List<Validator<? super Transforms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Transforms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Transforms> validator() {
		return new TransformsValidator();
	}

	@Override
	public Validator<? super Transforms> typeFormatValidator() {
		return new TransformsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Transforms, Set<String>> onlyExistsValidator() {
		return new TransformsOnlyExistsValidator();
	}
}
