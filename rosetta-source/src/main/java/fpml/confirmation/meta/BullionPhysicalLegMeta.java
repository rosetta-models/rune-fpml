package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BullionPhysicalLeg;
import fpml.confirmation.validation.BullionPhysicalLegTypeFormatValidator;
import fpml.confirmation.validation.BullionPhysicalLegValidator;
import fpml.confirmation.validation.exists.BullionPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BullionPhysicalLeg.class)
public class BullionPhysicalLegMeta implements RosettaMetaData<BullionPhysicalLeg> {

	@Override
	public List<Validator<? super BullionPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BullionPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BullionPhysicalLeg> validator() {
		return new BullionPhysicalLegValidator();
	}

	@Override
	public Validator<? super BullionPhysicalLeg> typeFormatValidator() {
		return new BullionPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BullionPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new BullionPhysicalLegOnlyExistsValidator();
	}
}
