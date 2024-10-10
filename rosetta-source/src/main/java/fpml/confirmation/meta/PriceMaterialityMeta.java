package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PriceMateriality;
import fpml.confirmation.validation.PriceMaterialityTypeFormatValidator;
import fpml.confirmation.validation.PriceMaterialityValidator;
import fpml.confirmation.validation.exists.PriceMaterialityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PriceMateriality.class)
public class PriceMaterialityMeta implements RosettaMetaData<PriceMateriality> {

	@Override
	public List<Validator<? super PriceMateriality>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceMateriality, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PriceMateriality> validator() {
		return new PriceMaterialityValidator();
	}

	@Override
	public Validator<? super PriceMateriality> typeFormatValidator() {
		return new PriceMaterialityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceMateriality, Set<String>> onlyExistsValidator() {
		return new PriceMaterialityOnlyExistsValidator();
	}
}
