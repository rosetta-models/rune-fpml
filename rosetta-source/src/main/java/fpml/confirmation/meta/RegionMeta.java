package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Region;
import fpml.confirmation.validation.RegionTypeFormatValidator;
import fpml.confirmation.validation.RegionValidator;
import fpml.confirmation.validation.exists.RegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Region.class)
public class RegionMeta implements RosettaMetaData<Region> {

	@Override
	public List<Validator<? super Region>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Region, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Region> validator() {
		return new RegionValidator();
	}

	@Override
	public Validator<? super Region> typeFormatValidator() {
		return new RegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Region, Set<String>> onlyExistsValidator() {
		return new RegionOnlyExistsValidator();
	}
}
