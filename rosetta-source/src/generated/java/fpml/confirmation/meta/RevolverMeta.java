package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Revolver;
import fpml.confirmation.validation.RevolverTypeFormatValidator;
import fpml.confirmation.validation.RevolverValidator;
import fpml.confirmation.validation.exists.RevolverOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Revolver.class)
public class RevolverMeta implements RosettaMetaData<Revolver> {

	@Override
	public List<Validator<? super Revolver>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Revolver, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Revolver> validator() {
		return new RevolverValidator();
	}

	@Override
	public Validator<? super Revolver> typeFormatValidator() {
		return new RevolverTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Revolver, Set<String>> onlyExistsValidator() {
		return new RevolverOnlyExistsValidator();
	}
}
