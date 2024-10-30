package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Material;
import fpml.confirmation.validation.MaterialTypeFormatValidator;
import fpml.confirmation.validation.MaterialValidator;
import fpml.confirmation.validation.exists.MaterialOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Material.class)
public class MaterialMeta implements RosettaMetaData<Material> {

	@Override
	public List<Validator<? super Material>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Material, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Material> validator() {
		return new MaterialValidator();
	}

	@Override
	public Validator<? super Material> typeFormatValidator() {
		return new MaterialTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Material, Set<String>> onlyExistsValidator() {
		return new MaterialOnlyExistsValidator();
	}
}
