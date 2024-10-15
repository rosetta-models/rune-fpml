package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDelivery;
import fpml.confirmation.validation.ElectricityDeliveryTypeFormatValidator;
import fpml.confirmation.validation.ElectricityDeliveryValidator;
import fpml.confirmation.validation.exists.ElectricityDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ElectricityDelivery.class)
public class ElectricityDeliveryMeta implements RosettaMetaData<ElectricityDelivery> {

	@Override
	public List<Validator<? super ElectricityDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ElectricityDelivery>create(fpml.confirmation.validation.datarule.ElectricityDeliveryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ElectricityDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityDelivery> validator() {
		return new ElectricityDeliveryValidator();
	}

	@Override
	public Validator<? super ElectricityDelivery> typeFormatValidator() {
		return new ElectricityDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDelivery, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryOnlyExistsValidator();
	}
}
