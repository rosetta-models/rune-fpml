package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasDelivery;
import fpml.confirmation.validation.GasDeliveryTypeFormatValidator;
import fpml.confirmation.validation.GasDeliveryValidator;
import fpml.confirmation.validation.exists.GasDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GasDelivery.class)
public class GasDeliveryMeta implements RosettaMetaData<GasDelivery> {

	@Override
	public List<Validator<? super GasDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasDelivery> validator() {
		return new GasDeliveryValidator();
	}

	@Override
	public Validator<? super GasDelivery> typeFormatValidator() {
		return new GasDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasDelivery, Set<String>> onlyExistsValidator() {
		return new GasDeliveryOnlyExistsValidator();
	}
}
