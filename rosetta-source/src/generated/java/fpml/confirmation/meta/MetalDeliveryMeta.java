package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MetalDelivery;
import fpml.confirmation.validation.MetalDeliveryTypeFormatValidator;
import fpml.confirmation.validation.MetalDeliveryValidator;
import fpml.confirmation.validation.exists.MetalDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MetalDelivery.class)
public class MetalDeliveryMeta implements RosettaMetaData<MetalDelivery> {

	@Override
	public List<Validator<? super MetalDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MetalDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MetalDelivery> validator() {
		return new MetalDeliveryValidator();
	}

	@Override
	public Validator<? super MetalDelivery> typeFormatValidator() {
		return new MetalDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MetalDelivery, Set<String>> onlyExistsValidator() {
		return new MetalDeliveryOnlyExistsValidator();
	}
}
