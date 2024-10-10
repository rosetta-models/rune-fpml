package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OilPhysicalLeg;
import fpml.confirmation.validation.OilPhysicalLegTypeFormatValidator;
import fpml.confirmation.validation.OilPhysicalLegValidator;
import fpml.confirmation.validation.exists.OilPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OilPhysicalLeg.class)
public class OilPhysicalLegMeta implements RosettaMetaData<OilPhysicalLeg> {

	@Override
	public List<Validator<? super OilPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OilPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OilPhysicalLeg> validator() {
		return new OilPhysicalLegValidator();
	}

	@Override
	public Validator<? super OilPhysicalLeg> typeFormatValidator() {
		return new OilPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new OilPhysicalLegOnlyExistsValidator();
	}
}
