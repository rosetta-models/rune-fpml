package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPointsModelSequence;
import fpml.confirmation.validation.CommodityDeliveryPointsModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityDeliveryPointsModelSequenceValidator;
import fpml.confirmation.validation.exists.CommodityDeliveryPointsModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityDeliveryPointsModelSequence.class)
public class CommodityDeliveryPointsModelSequenceMeta implements RosettaMetaData<CommodityDeliveryPointsModelSequence> {

	@Override
	public List<Validator<? super CommodityDeliveryPointsModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryPointsModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDeliveryPointsModelSequence> validator() {
		return new CommodityDeliveryPointsModelSequenceValidator();
	}

	@Override
	public Validator<? super CommodityDeliveryPointsModelSequence> typeFormatValidator() {
		return new CommodityDeliveryPointsModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryPointsModelSequence, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryPointsModelSequenceOnlyExistsValidator();
	}
}
