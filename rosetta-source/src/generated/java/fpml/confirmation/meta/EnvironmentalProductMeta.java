package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EnvironmentalProduct;
import fpml.confirmation.validation.EnvironmentalProductTypeFormatValidator;
import fpml.confirmation.validation.EnvironmentalProductValidator;
import fpml.confirmation.validation.exists.EnvironmentalProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnvironmentalProduct.class)
public class EnvironmentalProductMeta implements RosettaMetaData<EnvironmentalProduct> {

	@Override
	public List<Validator<? super EnvironmentalProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EnvironmentalProduct> validator() {
		return new EnvironmentalProductValidator();
	}

	@Override
	public Validator<? super EnvironmentalProduct> typeFormatValidator() {
		return new EnvironmentalProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalProduct, Set<String>> onlyExistsValidator() {
		return new EnvironmentalProductOnlyExistsValidator();
	}
}
