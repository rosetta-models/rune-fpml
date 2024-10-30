package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasPhysicalQuantity;
import fpml.confirmation.validation.GasPhysicalQuantityTypeFormatValidator;
import fpml.confirmation.validation.GasPhysicalQuantityValidator;
import fpml.confirmation.validation.exists.GasPhysicalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GasPhysicalQuantity.class)
public class GasPhysicalQuantityMeta implements RosettaMetaData<GasPhysicalQuantity> {

	@Override
	public List<Validator<? super GasPhysicalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.GasPhysicalQuantity>create(fpml.confirmation.validation.datarule.GasPhysicalQuantityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GasPhysicalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasPhysicalQuantity> validator() {
		return new GasPhysicalQuantityValidator();
	}

	@Override
	public Validator<? super GasPhysicalQuantity> typeFormatValidator() {
		return new GasPhysicalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasPhysicalQuantity, Set<String>> onlyExistsValidator() {
		return new GasPhysicalQuantityOnlyExistsValidator();
	}
}
