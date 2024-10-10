package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonDeliverableSettlement;
import fpml.confirmation.validation.NonDeliverableSettlementTypeFormatValidator;
import fpml.confirmation.validation.NonDeliverableSettlementValidator;
import fpml.confirmation.validation.exists.NonDeliverableSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NonDeliverableSettlement.class)
public class NonDeliverableSettlementMeta implements RosettaMetaData<NonDeliverableSettlement> {

	@Override
	public List<Validator<? super NonDeliverableSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NonDeliverableSettlement>create(fpml.confirmation.validation.datarule.NonDeliverableSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NonDeliverableSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonDeliverableSettlement> validator() {
		return new NonDeliverableSettlementValidator();
	}

	@Override
	public Validator<? super NonDeliverableSettlement> typeFormatValidator() {
		return new NonDeliverableSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonDeliverableSettlement, Set<String>> onlyExistsValidator() {
		return new NonDeliverableSettlementOnlyExistsValidator();
	}
}
