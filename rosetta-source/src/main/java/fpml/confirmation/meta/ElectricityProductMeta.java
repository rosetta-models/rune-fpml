package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityProduct;
import fpml.confirmation.validation.ElectricityProductTypeFormatValidator;
import fpml.confirmation.validation.ElectricityProductValidator;
import fpml.confirmation.validation.exists.ElectricityProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ElectricityProduct.class)
public class ElectricityProductMeta implements RosettaMetaData<ElectricityProduct> {

	@Override
	public List<Validator<? super ElectricityProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityProduct> validator() {
		return new ElectricityProductValidator();
	}

	@Override
	public Validator<? super ElectricityProduct> typeFormatValidator() {
		return new ElectricityProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityProduct, Set<String>> onlyExistsValidator() {
		return new ElectricityProductOnlyExistsValidator();
	}
}
