package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OilPipelineDelivery;
import fpml.confirmation.validation.OilPipelineDeliveryTypeFormatValidator;
import fpml.confirmation.validation.OilPipelineDeliveryValidator;
import fpml.confirmation.validation.exists.OilPipelineDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OilPipelineDelivery.class)
public class OilPipelineDeliveryMeta implements RosettaMetaData<OilPipelineDelivery> {

	@Override
	public List<Validator<? super OilPipelineDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OilPipelineDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OilPipelineDelivery> validator() {
		return new OilPipelineDeliveryValidator();
	}

	@Override
	public Validator<? super OilPipelineDelivery> typeFormatValidator() {
		return new OilPipelineDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilPipelineDelivery, Set<String>> onlyExistsValidator() {
		return new OilPipelineDeliveryOnlyExistsValidator();
	}
}
