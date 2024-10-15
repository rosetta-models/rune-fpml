package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Manifest;
import fpml.confirmation.validation.ManifestTypeFormatValidator;
import fpml.confirmation.validation.ManifestValidator;
import fpml.confirmation.validation.exists.ManifestOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Manifest.class)
public class ManifestMeta implements RosettaMetaData<Manifest> {

	@Override
	public List<Validator<? super Manifest>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Manifest, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Manifest> validator() {
		return new ManifestValidator();
	}

	@Override
	public Validator<? super Manifest> typeFormatValidator() {
		return new ManifestTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Manifest, Set<String>> onlyExistsValidator() {
		return new ManifestOnlyExistsValidator();
	}
}
