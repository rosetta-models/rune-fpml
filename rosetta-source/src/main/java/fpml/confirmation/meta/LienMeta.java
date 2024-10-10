package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Lien;
import fpml.confirmation.validation.LienTypeFormatValidator;
import fpml.confirmation.validation.LienValidator;
import fpml.confirmation.validation.exists.LienOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Lien.class)
public class LienMeta implements RosettaMetaData<Lien> {

	@Override
	public List<Validator<? super Lien>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Lien, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Lien> validator() {
		return new LienValidator();
	}

	@Override
	public Validator<? super Lien> typeFormatValidator() {
		return new LienTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Lien, Set<String>> onlyExistsValidator() {
		return new LienOnlyExistsValidator();
	}
}
