package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.validation.PhysicalSettlementTypeFormatValidator;
import fpml.confirmation.validation.PhysicalSettlementValidator;
import fpml.confirmation.validation.exists.PhysicalSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PhysicalSettlement.class)
public class PhysicalSettlementMeta implements RosettaMetaData<PhysicalSettlement> {

	@Override
	public List<Validator<? super PhysicalSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PhysicalSettlement>create(fpml.confirmation.validation.datarule.PhysicalSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PhysicalSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PhysicalSettlement> validator() {
		return new PhysicalSettlementValidator();
	}

	@Override
	public Validator<? super PhysicalSettlement> typeFormatValidator() {
		return new PhysicalSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalSettlement, Set<String>> onlyExistsValidator() {
		return new PhysicalSettlementOnlyExistsValidator();
	}
}
