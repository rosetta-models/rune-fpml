package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityOptionFeaturesModelSequence;
import fpml.confirmation.validation.CommodityOptionFeaturesModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityOptionFeaturesModelSequenceValidator;
import fpml.confirmation.validation.exists.CommodityOptionFeaturesModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityOptionFeaturesModelSequence.class)
public class CommodityOptionFeaturesModelSequenceMeta implements RosettaMetaData<CommodityOptionFeaturesModelSequence> {

	@Override
	public List<Validator<? super CommodityOptionFeaturesModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityOptionFeaturesModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityOptionFeaturesModelSequence> validator() {
		return new CommodityOptionFeaturesModelSequenceValidator();
	}

	@Override
	public Validator<? super CommodityOptionFeaturesModelSequence> typeFormatValidator() {
		return new CommodityOptionFeaturesModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityOptionFeaturesModelSequence, Set<String>> onlyExistsValidator() {
		return new CommodityOptionFeaturesModelSequenceOnlyExistsValidator();
	}
}
